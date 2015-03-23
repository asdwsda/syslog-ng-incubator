package org.syslog_ng;

public class GSoCStructuredDestination extends StructuredLogDestination {

  private String name;
  private LogTemplate msgTemplate;
  private String msgTemplateString;


  public GSoCStructuredDestination(long handle) {
    super(handle);
    msgTemplateString = "${ISODATE} ${MESSAGE}; nvpairs: $(format-json --scope everything)";
  }

  public void deinit() {
    msgTemplate.release();
    msgTemplate = null;
    System.out.println("Deinit");
  }

  public void onMessageQueueEmpty() {
    System.out.println("onMessageQueueEmpty");
    return;
  }

  public boolean init() {
    msgTemplate = new LogTemplate(getConfigHandle());
    name = getOption("name");
    if (name == null) {
      System.err.println("Name is a required option for this destination");
      return false;
    }
    System.out.println("Init " + name);
    return msgTemplate.compile(msgTemplateString);
  }

  public boolean open() {
    return true;
  }

  public boolean isOpened() {
    return true;
  }

  public void close() {
    System.out.println("close");
  }

  public boolean send(LogMessage msg) {
    msg.setValue("GSoC", "Task0");
    System.out.println(msgTemplate.format(msg));
    return true;
  }
}
