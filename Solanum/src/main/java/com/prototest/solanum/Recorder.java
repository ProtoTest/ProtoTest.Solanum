package com.prototest.solanum;

import java.awt.*;

/**
 * Created by Brian on 8/12/2014.
 */
public class Recorder {

    public static void startRecording() {
        final Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Rectangle screenBounds = new Rectangle(toolkit.getScreenSize());

        // First, let's make a IMediaWriter to write the file.
        final IMediaWriter writer = ToolFactory.makeWriter("output.mp4");

// We tell it we're going to add one video stream, with id 0,
// at position 0, and that it will have a fixed frame rate of
// FRAME_RATE.
        writer.addVideoStream(0, 0,
                FRAME_RATE,
                screenBounds.width, screenBounds.height);

        // Now, we're going to loop
        long startTime = System.nanoTime();
        for (int index = 0; index < SECONDS_TO_RUN_FOR * FRAME_RATE.getDouble(); index++) {
            // take the screen shot
            BufferedImage screen = robot.createScreenCapture(screenBounds);

            // convert to the right image type
            BufferedImage bgrScreen = convertToType(screen,
                    BufferedImage.TYPE_3BYTE_BGR);

            // encode the image to stream #0
            writer.encodeVideo(0, bgrScreen,
                    System.nanoTime() - startTime, TimeUnit.NANOSECONDS);
            System.out.println("encoded image: " + index);

            // sleep for framerate milliseconds
            Thread.sleep((long) (1000 / FRAME_RATE.getDouble()));
        }
// Finally we tell the writer to close and write the trailer if
// needed
        writer.close();
    }
}
