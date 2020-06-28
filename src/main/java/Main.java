import coffeemail.mail.Mail;
import coffeemail.module.*;
import coffeemail.module.Module;
import coffeemail.module.annotation.*;
import coffeemail.module.event.Listener;
import coffeemail.module.event.mail.MailReceiveEvent;
import coffeemail.module.event.mail.MailSendEvent;
import coffeemail.module.event.mail.PreMailReceiveEvent;
import coffeemail.module.event.mail.PreMailSendEvent;
import coffeemail.module.event.module.ModuleLoadEvent;
import coffeemail.module.event.module.ModulesLoadedEvent;

@ModuleMain
@ModuleName(modulename = "AutoResponder")
@ModuleVersion(moduleversion = "1.0")
@ModuleAuthor(moduleauthor = "podpage")
public class Main extends Module {

    @ModuleConfig
    public static String response = "Received your email!";
    public void load() {
        addListener(new Listener() {
            @Override
            public void sendMailEvent(MailSendEvent e) {

            }

            @Override
            public void presendMailEvent(PreMailSendEvent e) {

            }

            @Override
            public void receiveMailEvent(MailReceiveEvent e) {
                Mail mail = new Mail(e.getMail().getReceiver().setName("Auto-Reply"),
                        e.getMail().getSender(),
                        "Email received!",
                        response);
                mail.send();
            }

            @Override
            public void prereceiveMailEvent(PreMailReceiveEvent e) {

            }

            @Override
            public void loadModulEvent(ModuleLoadEvent e) {

            }

            @Override
            public void loadedModulesEvent(ModulesLoadedEvent e) {

            }
        });
    }

}
