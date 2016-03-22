package com.company.chapter15IO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by oleg on 21.03.16.
 */
public class DirList {
    public static void main(String[] args) {
        File path = new File(" ");
        String [] list;
        if (args.length != 0) {
            System.out.println("args.length = 0");
            list = path.list();
        } else {
            System.out.println("args.length !=0");
            list = path.list(new DirFilter("D */.java"));
        }
        System.out.println("before sort");
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        System.out.println("after sort");
        for (String s : list) {
            System.out.println(s);
        }
    }
}


class DirFilter implements FilenameFilter {

    private Pattern pattern;

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);

    }
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
