public class TestArea {
    public static <T> void main(String[] args){
        LinkedSetWithChainOfNodes<String> set3 = new LinkedSetWithChainOfNodes<>();
        LinkedSetWithChainOfNodes<String> set4 = new LinkedSetWithChainOfNodes<>();
        set3.add("D");
        set3.add("X");
        set3.add("A");
        set3.add("C");
        set4.add("B");
        set4.add("A");
        set4.add("C");
        set4.add("Z");
        LinkedSetWithChainOfNodes<String> everything = set3.union(set4);
        System.out.println(everything);
    }

}
