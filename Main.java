package Assignment2;

import Assignment2.Adapter.PDFDocumentAdapter;
import Assignment2.Bridge.HighlightRenderEngine;
import Assignment2.Bridge.RenderEngine;
import Assignment2.Bridge.SimpleRenderEngine;
import Assignment2.Facade.DocumentFacade;
import Assignment2.Flyweight.DocumentFactory;

public class Main {
    public static void main(String[] args) {
        DocumentFactory documentFactory = new DocumentFactory();
        RenderEngine simpleEngine = new SimpleRenderEngine();
        RenderEngine highlightEngine = new HighlightRenderEngine();

        DocumentFacade facade = new DocumentFacade(documentFactory, simpleEngine);

        // 1. Использование Proxy для ленивой загрузки
        System.out.println("1. Ленивая загрузка документов:");
        facade.displayDocument("Report");

        // 2. Использование декоратора для добавления водяного знака
        System.out.println("\n2. Добавление водяного знака:");
        facade.displayDocumentWithWatermark("Report");

        // 3. Использование Flyweight для повторного использования документа
        System.out.println("\n3. Повторное использование документа:");
        facade.displayDocument("Report");

        // 4. Использование Composite для работы с группой документов
        System.out.println("\n4. Работа с группами документов:");
        DocumentGroup group = new DocumentGroup();
        group.addDocument(documentFactory.createDocument("Report"));
        group.addDocument(documentFactory.createDocument("Presentation"));
        group.display();

        // 5. Использование Adapter для работы с PDF
        System.out.println("\n5. Работа с PDF документами через Adapter:");
        Document pdfDocument = new PDFDocumentAdapter("document.pdf");
        pdfDocument.display();

        // 6. Использование Bridge для рендеринга
        System.out.println("\n6. Рендеринг документа через движок:");
        facade.renderDocument("Report");
        facade.renderDocument("Report", highlightEngine);
    }
}
