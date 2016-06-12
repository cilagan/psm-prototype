package gov.nsf.research.document.service.model;

import java.io.Serializable;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Parent base class of all transfer object, providing extension point and location for common functionality.
 *
 * This base class gives a vanilla implementation of toString, equals, hashCode and clone which are
 * better than you'll get from Object.  All of these methods can be overridden, thus there isn't a
 * compelling reason to not have all transfer objects extend this class.
 *
 */
@javax.xml.bind.annotation.XmlTransient
public abstract class AbstractTransferObject implements Serializable, Cloneable {

	/**
	 *
	 */
	private static final long serialVersionUID = -4599533423915343386L;

	// this method is not final on purpose, it is a default implementation used most commonly
	//	in generated transfer objects.  Checkstyle complains that this isn't final, but this is by design.
	//CHECKSTYLE:OFF
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	//CHECKSTYLE:ON
		return ToStringBuilder.reflectionToString(this);
	}

	// this method is not final on purpose, it is a default implementation used most commonly
	//	in generated transfer objects.  Checkstyle complains that this isn't final, but this is by design.
	//CHECKSTYLE:OFF
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
	//CHECKSTYLE:ON
		// not the fastest implementation. To make faster, write equals methods
		// by hand on all objects in the object graph.
		// we are using EqualsBuilder to minimize the amount of hand editing we
		// do to the GENERATED object graph at this time.
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	// this method is not final on purpose, it is a default implementation used most commonly
	//	in generated transfer objects.  Checkstyle complains that this isn't final, but this is by design.
	//CHECKSTYLE:OFF
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
	//CHECKSTYLE:ON
		// not the fastest implementation. To make faster, write hashCode
		// methods by hand on all objects in the object graph.
		// we are using HashCodeBuilder to minimize the amount of hand editing
		// we do to the GENERATED object graph at this time.
		return HashCodeBuilder.reflectionHashCode(this);
	}

	// checkstyle doesn't like any usage at all of this method and wants this to be final.
	//	This method's existance here is intentional, it doesn't force usage but rather enables it.  Sorry checkstyle.
	//  This is a default implementation used most commonly in generated transfer objects.
	//	Checkstyle complains that this isn't final, but this is by design.
	//CHECKSTYLE:OFF
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
	//CHECKSTYLE:ON
		// not the fastest implementation. To make faster, write clone methods
		// by hand on all objects in the object graph.
		// we are using SerializationUtils to minimize the amount of hand
		// editing we do to the GENERATED object graph at this time.
		return SerializationUtils.clone(this);
	}

}
