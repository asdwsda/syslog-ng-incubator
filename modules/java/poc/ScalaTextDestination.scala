import org.syslog_ng._

class ScalaTextDestination (var handle: Long) extends TextLogDestination (handle) {

  var name: String = _

  def deinit() = {
    InternalMessageSender.debug("Deinit")
  }

  def onMessageQueueEmpty() = {
    InternalMessageSender.debug("onMessageQueueEmpty")
  }

  def init() : Boolean = {
    name = getOption("name")
    if (name == null) {
      InternalMessageSender.error("Name is a required option for this destination")
      return false
    }
    InternalMessageSender.debug("Init " + name)
    return true
  }

  def open() : Boolean = {
    InternalMessageSender.debug("open")
    return true
  }

  def isOpened() : Boolean = {
    InternalMessageSender.debug("isOpened")
    return true
  }

  def close() = {
    InternalMessageSender.debug("close")
  }

  def send(message : String) : Boolean = {
    InternalMessageSender.debug("Incoming message: " + message)
    return true
  }
}
