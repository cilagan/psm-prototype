package gov.nsf.research.psm.model;
/**
 * The Class ServiceResponse.
 * 
 * @version 1.0
 * 
 * 
 */
public class ServiceNotification extends AbstractTransferObject{

	/** The serialVersionUID */
	private static final long serialVersionUID = 7697285276984384253L;

	/** The warning type. */
	private NotificationType notificationType;

	/** The warning code. */
	private String notificationCode;

	/** The warning message. */
	private String notificationMessage;

	/**
	 * Gets the notification type.
	 * 
	 * @return the notification type
	 */
	public NotificationType getNotificationType() {
		return notificationType;
	}

	/**
	 * Gets the notification code.
	 * 
	 * @return the notification code
	 */
	public String getNotificationCode() {
		return notificationCode;
	}

	/**
	 * Gets the notification message.
	 * 
	 * @return the notification message
	 */
	public String getNotificationMessage() {
		return notificationMessage;
	}

	/**
	 * Sets the notification type.
	 * 
	 * @param notificationType
	 *            the new notification type
	 */
	public void setNotificationType(NotificationType notificationType) {
		this.notificationType = notificationType;
	}

	/**
	 * Sets the notification code.
	 * 
	 * @param notificationCode
	 *            the new notification code
	 */
	public void setNotificationCode(String notificationCode) {
		this.notificationCode = notificationCode;
	}

	/**
	 * Sets the notification message.
	 * 
	 * @param notificationMessage
	 *            the new notification message
	 */
	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}
}