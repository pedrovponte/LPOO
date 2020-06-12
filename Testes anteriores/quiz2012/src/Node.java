import java.util.Objects;

public abstract class Node implements Cloneable {
    private FileSystem fileSystem;
    private String name;
    private Folder parent;
    private int number = 0;
    private static int i = 0;

    public Node(Folder parent, String name) throws DuplicateNameException {
        this.name = name;
        this.parent = parent;
        this.fileSystem = parent.getFileSystem();
        parent.addChild(this);
        i++;
        this.number = i;
    }

    public Node(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
        this.name = "";
        i++;
        this.number = i;
    }

    public FileSystem getFileSystem() {
        return fileSystem;
    }

    public void setFileSystem(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Folder getParent() {
        return parent;
    }

    public void setParent(Folder parent) {
        this.parent = parent;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static void resetNumbering(int number) {
        i = number;
    }
    public abstract int getSize();

    public String getPath() {
        if(parent != null)
            return fileSystem.getNameFormatter().getSeparator() + parent.getName() + fileSystem.getNameFormatter().getSeparator() + name;
        else
            return "";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Node node = (Node) object;
        return Objects.equals(fileSystem, node.fileSystem) &&
                Objects.equals(name, node.name) &&
                Objects.equals(parent, node.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileSystem, name, parent);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
