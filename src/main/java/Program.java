import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Program {
    private static String GetViewByName(String viewName) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream(viewName);
        return new String(input.readAllBytes(), StandardCharsets.UTF_8);
    }

    private static String GenerateIndexView(List<Object> viewModel) throws IOException {
        var indexFile = GetViewByName("index.html");

        var htmlBuilder = new HtmlBuilder();
        for (var model: viewModel)
            htmlBuilder.append(String.format("<li>%s</li>", "Hello World"));

        indexFile = indexFile.replace("$elements", htmlBuilder.toString());
        return indexFile;
    }

    public static void main(String[] args) throws IOException {

        var indexFileContent = GenerateIndexView(new ArrayList<>());

    }
}
