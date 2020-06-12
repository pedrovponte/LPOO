public class File extends Node {
    private int size;

    public File(Folder parent, String name) throws DuplicateNameException {
        super(parent, name);
    }

    public File(Folder parent, String name, int size) throws DuplicateNameException {
        super(parent, name);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


}
