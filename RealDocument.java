package Assignment2;

// Реальный документ, который требует загрузки
public class RealDocument implements Document {
    private String title;

    public RealDocument(String title) {
        this.title = title;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Загрузка документа: " + title);
    }

    @Override
    public void display() {
        System.out.println("Отображение документа: " + title);
    }
}