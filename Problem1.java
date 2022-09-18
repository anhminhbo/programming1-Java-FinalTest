import java.util.Objects;

public class Problem1 {
  public static void main(String[] args) throws IncompatibleAppException {

      Phone phone = new MinhPhone("Minh", "Nguyen");
      App app1 = new CanvasApp("app1",5);
      App app2 = new GameApp("app2",5);
      App app3 = new App("app3",5);
      phone.installApp(app1);
      phone.installApp(app2);
      phone.installApp(app3);
  
      
  }
  // Phone
  public static class Phone {
    private String manuName;
    private String modelName;
  
    public Phone(String manuName, String modelName) {
      this.manuName = manuName;
      this.modelName = modelName;
    }
    
    public void installApp(App app) throws IncompatibleAppException {
      if (app instanceof  AppleCompatible && app instanceof AndroidCompatible) {
        System.out.println("Visit " + this.getAppHub() + " to get more apps");
        ((AndroidCompatible) app).saveTime();
        ((AppleCompatible) app).saveMoney();
      } else {
        if (app instanceof AppleCompatible) {
          if (Objects.equals(this.getOs(), "Apple")) {
            System.out.println("Visit " + this.getAppHub() + " to get more apps");
            ((AppleCompatible) app).saveMoney();
          } else throw new IncompatibleAppException();
        } else  {
          if (app instanceof AndroidCompatible) {
            if (Objects.equals(this.getOs(), "Android")) {
              System.out.println("Visit " + this.getAppHub() + " to get more apps");
              ((AndroidCompatible) app).saveTime();
            } else throw new IncompatibleAppException();
          } else throw new IncompatibleAppException();
      }
        
      }
      
    }
  
    public  String getAppHub() {return "";}
    public String getOs() {return "";}
  
    public String getManuName() {
      return manuName;
    }
  
    public void setManuName(String manuName) {
      this.manuName = manuName;
    }
  
    public String getModelName() {
      return modelName;
    }
  
    public void setModelName(String modelName) {
      this.modelName = modelName;
    }
  }
  
  public class ApplePhone extends Phone {
    
    public ApplePhone(String manuName, String modelName) {
      super(manuName, modelName);
    }
    
    @Override
    public String getAppHub() {
      return "App Store";
    }
    
    @Override
    public String getOs() {
      return "Apple";
    }
  }
  
  public class AndroidPhone extends Phone {
    
    public AndroidPhone(String manuName, String modelName) {
      super(manuName, modelName);
    }
    
    @Override
    public String getAppHub() {
      return "Play Store";
    }
    
    @Override
    public String getOs() {
      return "Android";
    }
    
    
  }
  
  public static class MinhPhone extends Phone {
    
    public MinhPhone(String manuName, String modelName) {
      super(manuName, modelName);
    }
    
    @Override
    public String getAppHub() {
      return "Minh Store";
    }
    
    @Override
    public String getOs() {
      return "Minh";
    }
    
    
  }
  
  // App
  public static class App{
    private String name;
    private int versionNumber;
  
    public App(String name, int versionNumber) {
      this.name = name;
      this.versionNumber = versionNumber;
    }
  
    @Override
    public String toString() {
      return this.name + ":" + this.versionNumber;
    }
  }
  
  // Apple, Android, Minh compatiable
  interface AppleCompatible{
    String saveMoney();
  }
  
  interface AndroidCompatible {
    String saveTime();
  }
  
  // Canvas and Game app
  public static class CanvasApp extends App implements AppleCompatible {
  
    public CanvasApp(String name, int versionNumber) {
      super(name, versionNumber);
    }
  
    @Override
    public String saveMoney() {
      return "Save enough money to install" + super.toString();
    }
  }
  
  public static class GameApp extends App implements AndroidCompatible{
    public GameApp(String name, int versionNumber) {
      super(name, versionNumber);
    }
  
    @Override
    public String saveTime() {
      return "Save enough time to install" + super.toString();
    }
  }
  
//  Exception
  public static class IncompatibleAppException extends Exception{
  public IncompatibleAppException() {
    super("App is not compatible with phone");
  }
}
}
