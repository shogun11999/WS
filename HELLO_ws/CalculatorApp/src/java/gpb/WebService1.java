package gpb;

// это аннотации, т.е. способ отметить наши классы и методы,
// как связанные с веб-сервисной технологией
import java.io.File;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

// говорим, что наш интерфейс будет работать как веб-сервис
@WebService
// говорим, что веб-сервис будет использоваться для вызова методов
@SOAPBinding(style =SOAPBinding.Style.RPC)
public interface WebService1{
    // говорим, что этот метод можно вызывать удаленно
    @WebMethod
    public String getHelloString(String name);
    
    @WebMethod
    public File getxmlFile(String domainLogs,String inn); 
    
    @WebMethod
    public String getName(String domainLogs, String inn); 
}