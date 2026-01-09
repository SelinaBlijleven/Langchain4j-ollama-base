/**
 * EmbeddingStoreBuilder.java
 * <p>
 * A helper class that builds a vector store for RAG from internal documents.
 * You are free to reuse and adapt this class.
 * <p>
 * @author  Lina Blijleven  <selina.blijleven@code-cafe.nl>
 */
package codecafe.agenticllm.rag;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;

import java.util.List;

public class InMemoryEmbeddingStore {

    // Simple InMemory implementation, but we could use different types of embedding stores for this.
    dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore<TextSegment> embeddingStore;

    /**
     * Constructor
     * Builds an in-memory embedding store, which we can
     * add our documents to.
     */
    public InMemoryEmbeddingStore() {
        // For demo/prototype purposes, we can keep the embedding store in memory,
        // but there are of course nicer and faster ways to do this.
        embeddingStore = new dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore<>();
    }

    /**
     * Statically create an embedding store from a local document path.
     * This can be a slow process if we have a lot of data, since we reindex
     * everything in memory for the demos.
     *
     * @param   path    Document path
     * @return          Embedding store from given documents
     */
    public static EmbeddingStore<TextSegment> fromPath(String path) {
        return new InMemoryEmbeddingStore().addDocumentsFromPath(path).embeddingStore();
    }

    /**
     * Add any collection of documents to the embedding store.
     * You could reuse this function for web search documents.
     *
     * @param   documents   Documents to embed for retrieval later
     */
    private void addDocuments(List<Document> documents) {
        // Ingest the documents using the default implementation of the EmbeddingStoreIngestor.
        // This will result in a warning that the max token size for embeddings uses the default too.
        EmbeddingStoreIngestor.ingest(documents, embeddingStore);
    }

    /**
     * Add documents from a local path.
     *
     * @param   documentPath    Path to retrieve documents from
     * @return  EmbeddingStoreBuilder
     */
    public InMemoryEmbeddingStore addDocumentsFromPath(String documentPath) {
        // Read the documents with a prebuilt loader, so we don't have to think about file handling
        List<Document> documents = FileSystemDocumentLoader.loadDocuments(documentPath);
        // Use the internal addDocuments function
        addDocuments(documents);

        // allow chaining
        return this;
    }

    /**
     * Return the current version of the embedding store. Note that this will
     * be empty if you have not added any documents.
     *
     * @return  embedding store for RAG
     */
    public EmbeddingStore<TextSegment> embeddingStore() {
        return embeddingStore;
    }
}
