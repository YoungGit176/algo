package MutilSourcePageDemo;

import java.util.ArrayList;
import java.util.List;

public class MutilDataSourcePageUtil {

    public static void main(String[] args) {
        List<List<TestBean>> sourceList = new ArrayList<>();
        List<TestBean> testBeansA = new ArrayList<>();
        List<TestBean> testBeansB = new ArrayList<>();
        List<TestBean> testBeansC = new ArrayList<>();
        sourceList.add(testBeansA);
        sourceList.add(testBeansB);
        sourceList.add(testBeansC);
        for (int i = 0; i < 15; i++) {
            if (i<5) {
                testBeansA.add(new TestBean(i,"youngA"+i));
            } else if (i< 10) {
                testBeansB.add(new TestBean(i,"youngB"+i));
            } else {
                testBeansC.add(new TestBean(i,"youngC"+i));
            }
        }
        List<Integer> pages = new ArrayList<>();
        pages.add(testBeansA.size());
        pages.add(testBeansB.size());
        pages.add(testBeansC.size());
        List<TestBean> result = new ArrayList<>();
        List<PageUtil> pageList = getPageList(pages, 3, 5);
        for (int i = 0; i < sourceList.size(); i++) {
            if (pageList.get(i).getFrom() != -1) {
                int from = pageList.get(i).getFrom();
                int size = pageList.get(i).getSize();
                result.addAll(sourceList.get(i).subList(from, Math.min(from+size, pages.get(i))));
            }
        }
        System.out.println(result.size());
        result.stream().forEach(System.out::println);
    }


    public static List<PageUtil> getPageList(List<Integer> pages, Integer pageNum, Integer pageSize){
        int sourceNum = pages.size();
        int beginPage = (pageNum - 1) * pageSize;
        int insNum = 0;
        List<PageUtil> result = new ArrayList<>();
        int i = 0;
        for ( ;i< sourceNum; i++) {
            beginPage -= pages.get(i);
            if (beginPage < 0) {
                insNum = -beginPage;
                break;
            }
        }
        for (int j = 0; j< sourceNum; j++) {
            if (j < i) {
                result.add(new PageUtil(-1, -1));
            } else if (j == i) {
                PageUtil p1 = new PageUtil(pageSize, pages.get(j) + beginPage);
                result.add(p1);
            } else if (j > i && insNum < pageSize) {
                int size = pageSize - insNum;
                PageUtil p2 = new PageUtil(Math.min(size, pages.get(j)), 0);
                result.add(p2);
                insNum = insNum+ pages.get(j);
            } else {
                result.add(new PageUtil(-1,-1));
            }
        }
        return result;
    }
}
