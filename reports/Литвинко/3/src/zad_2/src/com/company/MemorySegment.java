package com.company;

public class MemorySegment {

    private int startIndex;
    private int endIndex;

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public int getSize(){
        return endIndex-startIndex;
    }

    public MemorySegment clone(){
        MemorySegment segment = new MemorySegment();
        segment.setStartIndex(startIndex);
        segment.setEndIndex(endIndex);
        return segment;
    }

    public String toString(){
        return "startIndex="+startIndex+"; endIndex="+endIndex;
    }
}
