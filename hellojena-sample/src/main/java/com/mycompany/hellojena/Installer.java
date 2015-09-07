package com.mycompany.hellojena;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.openide.modules.OnStart;

@OnStart
public class Installer implements Runnable {

    @Override
    public void run() {
        Model model = ModelFactory.createDefaultModel();
        model.createResource("http://example.org/alice", FOAF.Person)
                .addProperty(FOAF.name, "Alice")
                .addProperty(FOAF.mbox, model.createResource("mailto:alice@example.org"))
                .addProperty(FOAF.knows, model.createResource("http://example.org/bob"));
        model.write(System.out, "TURTLE");
    }

}
