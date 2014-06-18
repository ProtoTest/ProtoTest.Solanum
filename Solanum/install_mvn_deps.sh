mvn install:install-file -Dfile=lib/jai_codec.jar -DgroupId=com.sun.media \
    -DartifactId=jai_codec -Dversion=1.1.3 -Dpackaging=jar
mvn install:install-file -Dfile=lib/jai_core.jar -DgroupId=com.sun.media \
    -DartifactId=jai_core -Dversion=1.1.3 -Dpackaging=jar
