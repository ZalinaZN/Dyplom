public class SearchEnginePDF {
    String fileName;
    int pageNumber;
    int freq;

    public SearchEnginePDF(String fileName, int pageNumber, int freq) {
        this.fileName = fileName;
        this.pageNumber = pageNumber;
        this.freq = freq;
    }

    public String getFileName() {
        return fileName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getFreq() {
        return freq;
    }

    @Override
    public String toString() {
        return "SearchEnginePDF{" +
                "fileName =" + fileName + '\'' +
                ", pageNumber =" + pageNumber +
                ", freq =" + freq +
                '}';
    }
}
