package pv260.solid.ocp.original;

import pv260.solid.ocp.original.persistence.Persistence;

import java.nio.file.Paths;
import java.util.Date;

import static pv260.solid.ocp.original.persistence.PersistenceType.*;

public class Main {

    public static void main(String[] args) {
        Comment comment = new Comment("My comment",
                                      "This is interesting...",
                                      new Date(),
                                      "Pepa Zdepa");
        new Persistence(XML,
                        Paths.get("comments.xml")).persist(comment);
        new Persistence(CSV,
                        Paths.get("comments.csv")).persist(comment);
        new Persistence(JSON,
                Paths.get("comments.json")).persist(comment);
    }
}
