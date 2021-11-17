# README #

This is a program which parse XML file using SAXParser. 
Input file contains different types of files and path to them. 
The program parses it and print the whole path in one line.

### How it works ###

The program input can be like:

* -f &lt;xml_file&gt; -s &lt;input&gt;
* -f &lt;xml_file&gt;



There are several types of &lt;input&gt;
 
 
- Exact search
      * -f test-files.xml -s file-1498940214.xhtml
- Simple search

      * -f test-files.xml -s ‘*.java’
      
- Extended search

      * -f test-files.xml -S ‘.*?[a-z]{4}-\\d+\.[a-z]+’