package com.suri.java.collection;
import java.util.*;
/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 04/04/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */


class UniqueImages {
    public static class Image {
        private String filename;
        private int width;
        private int height;



        public Image(String filename, int width, int height) {
            this.filename = filename.toLowerCase();
            this.width = width;
            this.height = height;
        }
        /**
         * Two Images are considered equal if they have
         * the same filename (without the extension), and the
         * same number of pixels.
         * Thus, flag.jpg with width=60 height=40 is
         * equal to flag.gif with width=40 and height=60
         */
        public boolean equals(Object other) {
            Image o = (Image)other;
            if (filename == null || o.filename == null)
                return false;
            String[] components = filename.split("\\.");
            String[] ocomponents = o.filename.split("\\.");
            return components[0].equals(ocomponents[0]) &&
                    width * height == o.width * o.height;

        }

        /**
         *
         *  Hash code  of two Images are always  equal if they have
         * the same filename (without the extension), and the
         * same number of pixels.
         * Thus, flag.jpg with width=60 height=40 and
         * flag.gif with width=40 and height=60, always return the same
         * hash code
         * @return
         */
        @Override
        public int hashCode() {
            String fname[]=filename.split("\\.");
            int result = fname[0].hashCode();
            return result+ width*height;
        }

        public String toString() {
            return "Image: filename=" + filename + " Size=" + width*height;
        }
    }

    public static void printImages(Set<Image> images) {
        for(Image image: images) {
            System.out.println(image);
        }
    }

    public static void main(String[] args) {
        Image[] images = {new Image("flag.jpg", 40, 60),
                new Image("flag.gif", 40, 60),
                new Image("smile.gif", 100, 200),
                new Image("smile.gif", 50, 400),
                new Image("other.jpg", 40, 60),
                new Image("lenna.jpg", 512, 512),
                new Image("Lenna.jpg", 512, 512)};
        Set<Image> set = new HashSet<Image>(Arrays.asList(images));
        UniqueImages.printImages(set);
    }
}