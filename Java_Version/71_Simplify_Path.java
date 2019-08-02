/*
  Given an absolute path for a file (Unix-style), simplify it.

  For example,
        path = "/home/", => "/home"
        path = "/a/./b/../../c/", => "/c"
        path = "/a/../../b/../c//.//", => "/c"
        path = "/a//b////c/d//././/..", => "/a/b/c"

  In a UNIX-style file system, a period ('.') refers to the current directory,
so it can be ignored in a simplified path. Additionally, a double period ("..")
moves up a directory, so it cancels out whatever the last directory was. For
more information, look here:
https://en.wikipedia.org/wiki/Path_(computing)#Unix_style

Corner Cases:
  Did you consider the case where path = "/../"?
  In this case, you should return "/".

  Another corner case is the path might contain multiple slashes '/' together,
such as "/home//foo/". In this case, you should ignore redundant slashes and
return "/home/foo".*/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public String simplifyPath(String path) {

        if (path == null || path.isEmpty() || path.charAt(0) != '/') {
            throw new RuntimeException("illegal input");
        }


        Deque<String> deque = new ArrayDeque<>();
        int lastSlashIndex = 0;

        while (lastSlashIndex < path.length()) {

            int nextSlashIndex = lastSlashIndex + 1;
            while (nextSlashIndex < path.length() && path.charAt(nextSlashIndex) != '/') {
                nextSlashIndex++;
            }

            String currentPath = path.substring(
                    lastSlashIndex + 1, nextSlashIndex);
            lastSlashIndex = nextSlashIndex;

            if (currentPath.isEmpty() || currentPath.equals(".")) {
                continue;
            } else if (currentPath.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else {
                deque.addLast(currentPath);
            }
        }

        if (deque.isEmpty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty()) {

            result.append("/");
            result.append(deque.pollFirst());
        }

        return result.toString();
    }
}
