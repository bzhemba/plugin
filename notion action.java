import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.Nullable;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class NotionAction extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent event) {
        Editor editor = event.getData(PlatformDataKeys.EDITOR);


        String selectedText = editor.getSelectionModel().getSelectedText();
        String encoded = "";
        try {
            encoded = URLEncoder.encode(selectedText, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        String url = String.format("https://www.notion.so/my-projects-26e8d0c6de9e4eae88ee81bdac7b1970#78c00d1b1af444269cf8515a08ce6a82", encoded);
        Messages.showMessageDialog(url, "Notion Action", Messages.getInformationIcon());
        BrowserUtil.browse(url);


    }


    @Override
    public boolean isDumbAware() {
        return super.isDumbAware();
    }

}
