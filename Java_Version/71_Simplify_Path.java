/*
Given an absolute path for a file (Unix-style), simplify it.

        For example,
        path = "/home/", => "/home"
        path = "/a/./b/../../c/", => "/c"
        path = "/a/../../b/../c//.//", => "/c"
        path = "/a//b////c/d//././/..", => "/a/b/c"

        In a UNIX-style file system, a period ('.') refers to the current directory, so it can be ignored in a simplified path. Additionally, a double period ("..") moves up a directory, so it cancels out whatever the last directory was. For more information, look here: https://en.wikipedia.org/wiki/Path_(computing)#Unix_style

        Corner Cases:

        Did you consider the case where path = "/../"?
        In this case, you should return "/".
        Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
        In this case, you should ignore redundant slashes and return "/home/foo".*/

import java.util.Stack;

class Solution {

    public String simplifyPath(String path) {

        if (path == null || path.isEmpty() || path.charAt(0) != '/') {
            return path;
        }

        Stack<String> stack = new Stack<>();

        int pointer = 0;
        while (pointer != path.length()) {

            while (pointer != path.length() && path.charAt(pointer) == '/') {
                pointer++;
            }
            int startIndex = pointer;

            while (pointer != path.length() && path.charAt(pointer) != '/') {
                pointer++;
            }
            int endIndex = pointer;

            String currentString = path.substring(startIndex, endIndex);
            if (currentString.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!currentString.isEmpty()) {
                if (!currentString.equals(".")) {
                    stack.push(currentString);
                }
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {

            String currentPath = stack.pop();

            result.insert(0, currentPath);
            result.insert(0, "/");
        }

        return result.toString();
    }
}