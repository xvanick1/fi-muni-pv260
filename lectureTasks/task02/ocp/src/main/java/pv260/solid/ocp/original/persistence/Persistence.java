package pv260.solid.ocp.original.persistence;

import pv260.solid.ocp.original.Comment;
import pv260.solid.ocp.original.persistence.format.CsvPersistence;
import pv260.solid.ocp.original.persistence.format.JsonPersistence;
import pv260.solid.ocp.original.persistence.format.XmlPersistence;

import java.nio.file.Path;


public class Persistence {

    private final PersistenceType type;
    private final Path filePath;

    /**
     * @param type how the records will be stored
     * @param filePath if type is CSV/XML/JSON, this is the file records will be persisted to
     *                is null if type something else
     */
    public Persistence(PersistenceType type,
                       Path filePath) {
        this.type = type;
        this.filePath = filePath;
    }

    public void persist(Comment comment) {
        switch (type) {
            case CSV :
                CsvPersistence csvPersistence = new CsvPersistence(filePath);
                csvPersistence.persistCsv(comment);
                break;
            case XML :
                XmlPersistence xmlPersistence = new XmlPersistence(filePath);
                xmlPersistence.persistXml(comment);
                break;
            case JSON :
                JsonPersistence jsonPersistence = new JsonPersistence(filePath);
                jsonPersistence.persistJson(comment);
                break;
            default :
                throw new IllegalStateException("Unsupported persistence method: " + comment);
        }
    }


}
