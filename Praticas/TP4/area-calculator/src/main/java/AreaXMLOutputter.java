public class AreaXMLOutputter {
    SumProvider sum;

    public AreaXMLOutputter(SumProvider sum) {
        this.sum = sum;
    }

    public String output() {
        return "<area>" + sum.sum() + "</area>";
    }
}
