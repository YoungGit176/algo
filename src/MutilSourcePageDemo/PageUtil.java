package MutilSourcePageDemo;

public class PageUtil {

    private Integer size;
    private Integer from;

    public PageUtil(Integer size, Integer from) {
        this.size = size;
        this.from = from;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }
}
