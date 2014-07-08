package com.prototest;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 */
public class EggplantSuite {
    private final Pattern imageRegex = Pattern.compile("(.+)(\\.png|\\.tiff)");
    private final File suitePath;
    private Map<String, List<AssetEntry>> assets = new HashMap<String, List<AssetEntry>>();
    private final int suitePathLength;

    public class AssetEntry {
        private final String assetPath;

        private final String assetName;

        public AssetEntry(String assetPath, String assetName) {
            this.assetPath = assetPath;
            this.assetName = assetName;
        }

        public String getAssetPath() {
            return assetPath;
        }

        public String getAssetName() {
            return assetName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AssetEntry that = (AssetEntry) o;

            if (assetName != null ? !assetName.equals(that.assetName) : that.assetName != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return assetName != null ? assetName.hashCode() : 0;
        }
    }

    public Map<String, List<AssetEntry>> getAssets() {
        return assets;
    }

    public EggplantSuite(String suitePath) {
        File suitePath1;
        suitePath1 = new File(suitePath);
        if (!suitePath1.getName().equals("Images")) {
            suitePath1 = new File(suitePath1, "Images");
        }
        this.suitePath = suitePath1;
        this.suitePathLength = this.suitePath.getPath().split(File.separator).length;
    }

    public void readAssets() {
        Deque<File> toCheck = new LinkedList<File>();
        toCheck.add(suitePath);
        while (!toCheck.isEmpty()) {
            File current = toCheck.removeFirst();
            if (current.isDirectory()) {
                if (isCollection(current)) {
                    addAsset(current.getPath());
                } else {
                    File[] files = current.listFiles();
                    toCheck.addAll(files != null ? Arrays.<File>asList(files) : Collections.<File>emptyList());
                }
            } else {
                Matcher match = imageRegex.matcher(current.getPath());
                if (match.matches()) {
                    addAsset(match.group(1));
                }
            }
        }
        for (Map.Entry<String, List<AssetEntry>> deviceAssets : this.assets.entrySet()) {
            uniquifyAssets(deviceAssets.getValue());
        }
    }

    private void uniquifyAssets(List<AssetEntry> deviceAssets) {
        for (int i = 0; i < deviceAssets.size(); i++) {
            AssetEntry asset = deviceAssets.get(i);
            List<AssetEntry> subList = deviceAssets.subList(i+1, deviceAssets.size());
            List<AssetEntry> duplicateList = new LinkedList<AssetEntry>();
            duplicateList.add(asset);
            List<Integer> duplicate_is = new ArrayList<Integer>();
            duplicate_is.add(i);
            int truncated = i + 1;
            int next_i;
            while ((next_i = subList.indexOf(asset)) != -1) {
                duplicateList.add(subList.get(next_i));
                duplicate_is.add(truncated + next_i);
                subList = subList.subList(next_i+1, subList.size());
//                [n,n,n,n,n,m,n,m,n,n,m]
//                i            trunc            next_i
//                5            6
                //5

                truncated += next_i + 1;
            }
            if (duplicateList.size() > 1) {
                makeUniqueAssets(duplicateList);
                for (int y = 0; y < duplicateList.size(); y++) {
                    deviceAssets.set(duplicate_is.get(y), duplicateList.get(y));
                }
            }
        }
    }

    private void makeUniqueAssets(List<AssetEntry> duplicateList) {
        int pathPrefixes = 0;
        Set<String> uniques = new HashSet<String>(duplicateList.size());
        while (uniques.size() < duplicateList.size()) {
            pathPrefixes += 1;
            for (int i = 0; i < duplicateList.size(); i++) {
                AssetEntry asset = duplicateList.get(i);
                if (uniques.contains(asset)) {
                    continue;
                }
                List<String> assetPath = Arrays.asList(asset.getAssetPath().split(File.separator));
                String newName = String.join("", assetPath.subList(assetPath.size()-1-pathPrefixes, assetPath.size()));
                // try adding the new name; if it's not unique, remove it from the set.
                int old_uniques = uniques.size();
                uniques.add(newName);
                if (old_uniques == uniques.size()) {
                    uniques.remove(newName);
                }
                AssetEntry newEntry = new AssetEntry(asset.getAssetPath(),newName);
                duplicateList.set(i, newEntry);
            }
        }
    }

    private boolean containsDupes(List<AssetEntry> assetList) {
        return new HashSet<AssetEntry>(assetList).size() < assetList.size();
    }

    private boolean isCollection(File current) {
        if (!current.isDirectory()) {
            return false;
        }
        String curName = current.getName();
        for (File subFile : current.listFiles()) {
            if (subFile.isDirectory()) {
                return false;
            }
            String subFileName = subFile.getName();
            try {
                if (!subFileName.substring(0, curName.length()).equals(curName)) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }

        return true;
    }

    private void addAsset(String asset) {
        List<String> pathParts = splitPath(asset);
        List<String> relativeAsset = pathParts.subList(suitePathLength, pathParts.size());
        String devicePart = pathParts.get(suitePathLength);

        List<AssetEntry> deviceAssets = assets.get(devicePart);
        if (deviceAssets == null) {
            deviceAssets = new LinkedList<AssetEntry>();
        }
        deviceAssets.add(new AssetEntry(String.join(File.separator, relativeAsset), pathParts.get(pathParts.size() - 1)));
        assets.put(devicePart, deviceAssets);
    }

    private List<String> splitPath(File asset) {
        return Arrays.asList(asset.getPath().split(File.separator));
    }

    private List<String> splitPath(String asset) {
        return Arrays.asList(asset.split(File.separator));
    }
}
