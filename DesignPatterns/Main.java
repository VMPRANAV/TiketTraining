public class Main {

    public static void main(String[] args) throws InterruptedException {

        ConfigurationManager manager =
                ConfigurationManager.getInstance();

        ConfigSource jsonSource = ConfigSourceFactory.createSource("json", "config.json");

        manager.loadFromSource(jsonSource);

        System.out.println("JSON Configuration:");
        System.out.println("Server Port: "+ manager.getConfig("server.port"));

        System.out.println("Database URL: " + manager.getConfig("database.url"));

        ConfigSource yamlSource = ConfigSourceFactory.createSource("yaml", "config.yaml");

        manager.loadFromSource(yamlSource);

        System.out.println(" YAML Configuration:");

        System.out.println("Server Port: " + manager.getConfig("server.port")
        );

        System.out.println("Database URL: " + manager.getConfig("database.url")
        );

        ConfigSource propertiesSource = ConfigSourceFactory.createSource("properties", "config.properties");

        manager.loadFromSource(propertiesSource);

        System.out.println(" Properties Configuration:");

        System.out.println("Server Port: " + manager.getConfig("server.port"));

        System.out.println("Database URL: " + manager.getConfig("database.url"));

        manager.setConfig("application.name", "ConfigManagement");

        System.out.println(" Application Name: " + manager.getConfig("application.name"));

        ConfigurationManager manager2 = ConfigurationManager.getInstance();

        System.out.println(" Same Singleton instance: " + (manager == manager2));

        Runnable task = new Runnable() {
            @Override
            public void run() {
                ConfigurationManager threadManager = ConfigurationManager.getInstance();
                System.out.println(Thread.currentThread().getName() + " -> " + threadManager);
            }
        };

        Thread thread1 = new Thread(task, "thread1");
        Thread thread2 = new Thread(task, "thread2");
        Thread thread3 = new Thread(task, "thread3");
        Thread thread4 = new Thread(task, "thread4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        ConfigSource source1 =
                ConfigSourceFactory.createSource(
                        "json",
                        "config.json"
                );

        ConfigSource source2 =
                ConfigSourceFactory.createSource(
                        "json",
                        "config.json"
                );

        System.out.println("Same ConfigSource instance:" + (source1 == source2));

        manager.loadFromSource(source1);

        System.out.println("Before refresh:"+ manager.getConfig("server.port")
        );

        manager.refreshConfig();

        System.out.println("After refresh:"+ manager.getConfig("server.port"));
    }
}