package pv260.solid.ocp.original.persistence.format;

import org.json.simple.JSONObject;
import pv260.solid.ocp.original.Comment;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

@SuppressWarnings("unchecked")
public class JsonPersistence {
    private final Path path;

    public JsonPersistence(Path path) {
        this.path = path;
    }

    public void persistJson(Comment comment) {
        //This implementation is done this way just for demonstration
        //Should be changed to: if(exist) then appendNewLine, else createNewJson & appendNewLine
        final JSONObject commentDetailsJson = new JSONObject();
        commentDetailsJson.put("author", comment.getAuthor());
        commentDetailsJson.put("entered", comment.getEntered().toString());
        commentDetailsJson.put("headline", comment.getHeadline());
        commentDetailsJson.put("text", comment.getText());

        JSONObject commentJsonObject = new JSONObject();
        commentJsonObject.put("comment", commentDetailsJson);

        writeJson(commentJsonObject);
    }

    private void writeJson(JSONObject commentJsonObject) {
        try (FileWriter file = new FileWriter(path.toFile())) {
            file.write(commentJsonObject.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
