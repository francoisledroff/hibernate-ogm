package org.hibernate.ogm.datastore.mongodb.index;

/**
 * A document that contains the field and value pairs where
 * the field is the index key
 * and the value describes the type of index for that field.
 *
 * For an ascending index on a field, specify a value of 1;
 * for descending index, specify a value of -1.
 *
 * cf https://docs.mongodb.org/manual/reference/method/db.collection.createIndex/#db.collection.createIndex
 */
public enum IndexOrder {

    ASCENDING (1),
    DESCENDING(-1);

    private int indexKeyValue;

    IndexOrder(int indexKeyValue){
        this.indexKeyValue = indexKeyValue;
    }

    public int getIndexKeyValue() {
        return indexKeyValue;
    }
}
