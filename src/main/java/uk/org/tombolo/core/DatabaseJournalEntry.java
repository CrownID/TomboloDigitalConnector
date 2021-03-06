package uk.org.tombolo.core;

import javax.persistence.*;

@Entity
@Table(name="database_journal")
public class DatabaseJournalEntry {
    private Integer id;
    private String key;
    private String className;

    public DatabaseJournalEntry() {}
    public DatabaseJournalEntry(String className, String key) {
        this.className = className;
        this.key = key;
    }

    @Id
    @SequenceGenerator(name="database_journal_id_sequence",sequenceName="database_journal_id_sequence", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="database_journal_id_sequence")
    @Column(name="id")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="key")
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

    @Column(name="class_name")
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
}
