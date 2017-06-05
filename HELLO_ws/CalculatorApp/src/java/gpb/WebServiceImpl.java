package gpb;

// таже аннотация, что и при описании интерфейса,
import java.io.File;
import javax.jws.WebService;

// но здесь используется с параметром endpointInterface,
// указывающим полное имя класса интерфейса нашего веб-сервиса
@WebService(endpointInterface ="gpb.WebService1")
public class WebServiceImpl implements WebService1 {
    
    @Override
    public String getHelloString(String name){
        // просто возвращаем приветствие
        return "Привет, "+ name +"!";
    }
   
    @Override
    public File getxmlFile(String domainLogs,String inn)  {
            
       return searchOldLogs(new File(domainLogs),inn);
    }
    
    @Override
    public String getName(String domainLogs,String inn) {
        return getname(domainLogs,inn);
    }
    
    private static File searchOldLogs(File logDir, final String inn) {
    if (!logDir.isDirectory()) {
      throw new IllegalArgumentException(logDir + " is not a directory!");
    }
      File[] list = logDir.listFiles(new java.io.FileFilter()
      {
          public boolean accept(File pathname) {
              if ((pathname.isFile()) && (!pathname.isHidden())) {
                  if ((pathname.getName().contains((String) inn))) {
                      return true;
                  }
                      return false;
              }
              
           return false;
          }
      });
//    for (File i: list)
//        { System.out.println(list[0].getName());}
    return list[0];       
    }
    
    private static String getname (final String domainLogs,final String inn) {
    
    File logDir = new File(domainLogs);
        
    if (!logDir.isDirectory()) {
      throw new IllegalArgumentException(logDir + " is not a directory!");
    }
       
      File[] list = logDir.listFiles(new java.io.FileFilter()
        {
          public boolean accept(File pathname) {
              if ((pathname.isFile()) && (!pathname.isHidden())) {
                  if ((pathname.getName().contains((String) inn))) {
                      return true;
                  }
                      return false;
              }
              
           return true;
          }
      });
       
    for (File i: list)
        { System.out.println(list[0].getName());}
      return list[0].getName();      
    }

  }    
    
