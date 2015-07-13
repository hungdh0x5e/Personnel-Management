/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.alee.utils.filefilter.FilesFilter;
import java.io.File;

/**
 *
 * @author HUNGUYEN
 */
public class FileTypeFilter extends FilesFilter{
    private final String EXTENSION;
    private final String DESCRIPTION;
    
    public FileTypeFilter(String extension, String description){
        this.EXTENSION = extension;
        this.DESCRIPTION = description;
    }
    
    @Override
    public boolean accept(File f){
        if (f.isDirectory()){
            return true;
        } else {
            return f.getName().endsWith(EXTENSION);
        }
    }
    
    @Override
    public String getDescription(){
        return DESCRIPTION + String.format("(*%s)", EXTENSION);
    }
}
