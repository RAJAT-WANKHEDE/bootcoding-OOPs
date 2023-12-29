package com.bootcoding.OOPs.java.Project.report;

import java.util.List;

public interface IFileWriter extends DataWriter{
    public void write(List data, String outputPath);
}
