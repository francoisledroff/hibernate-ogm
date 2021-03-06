/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.ogm.datastore.mongodb.query.impl;

import java.io.Serializable;
import java.util.List;

import com.mongodb.DBObject;

/**
 * Describes a query to be executed against MongoDB.
 *
 * @author Gunnar Morling
 */
/**
 * @author Davide D'Alto
 */
public class MongoDBQueryDescriptor implements Serializable {

	public enum Operation {
		FIND,
		COUNT,
		AGGREGATE;
	}

	private final String collectionName;
	private final Operation operation;
	private final DBObject criteria;
	private final DBObject projection;
	private final DBObject orderBy;
	private final List<String> unwinds;

	public MongoDBQueryDescriptor(String collectionName, Operation operation, DBObject criteria, DBObject projection, DBObject orderBy, List<String> unwinds) {
		this.collectionName = collectionName;
		this.operation = operation;
		this.criteria = criteria;
		this.projection = projection;
		this.orderBy = orderBy;
		this.unwinds = unwinds;
	}

	/**
	 * The name of the collection to select from.
	 *
	 * @return the collection name
	 */
	public String getCollectionName() {
		return collectionName;
	}

	public Operation getOperation() {
		return operation;
	}

	/**
	 * Criteria describing the records to apply this query to.
	 *
	 * @return the {@link DBObject} representing the criteria
	 */
	public DBObject getCriteria() {
		return criteria;
	}

	/**
	 * The fields to be selected, if this query doesn't return all fields of the entity. Passed to the {@code keys}
	 * parameter of the MongoDB find API.
	 *
	 * @return the {@link DBObject} representing the projection
	 */
	public DBObject getProjection() {
		return projection;
	}

	/**
	 * Get the order criteria of the result of the query.
	 *
	 * @return the {@link DBObject} representing the order to apply the results of the query
	 */
	public DBObject getOrderBy() {
		return orderBy;
	}

	public List<String> getUnwinds() {
		return unwinds;
	}

	@Override
	public String toString() {
		return "MongoDBQueryDescriptor [collectionName=" + collectionName + ", where=" + criteria + ", projection=" + projection + ", orderBy=" + orderBy + "]";
	}
}
