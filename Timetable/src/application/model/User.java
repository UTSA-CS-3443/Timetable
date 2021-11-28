package application.model;

import java.io.*;

/**
 * The type User.
 */
public class User extends Calendar {
    private String name;
    private Settings settings;
    private TodoList todo;

    /**
     * Instantiates a new User.
     */
    public User() {
        super();
        this.settings = new Settings();
        this.todo = new TodoList();
    }

    /**
     * Gets serialize user.
     *
     * @return the serialize user
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static Object getSerializeUser() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("User.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        objectInputStream.close();
        return objectInputStream.readObject();
    }

    /**
     * Sets serialize user.
     *
     * @param object the object
     * @throws IOException the io exception
     */
    public static void setSerializeUser(Object object) throws IOException {
        File fileOut = new File("User.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(fileOut);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        fileOutputStream.close();
    }

    /**
     * Add todo.
     *
     * @param desc the desc
     */
    public void addTodo(String desc) {
        todo.addTodo(desc);
    }

    /**
     * Remove todo.
     *
     * @param id the id
     */
    public void removeTodo(int id) {
        todo.removeTodo(id);
    }

    /**
     * Update todo.
     *
     * @param id   the id
     * @param desc the desc
     */
    public void updateTodo(int id, String desc) {
        todo.updateTodo(id, desc);
    }

    /**
     * Update settings.
     *
     * @param option the option
     * @param value  the value
     */
    public void updateSettings(String option, String value) {
        switch (option) {
            case "alarm":
                this.settings.setAlarmSound(value);
                break;
            case "desktop":
                this.settings.setDesktopNotifi(Boolean.valueOf(value));
                break;
            case "muted":
                this.settings.setIsMuted(Boolean.valueOf(value));
                break;
            case "interval":
                this.settings.setPriorityInterval(Integer.valueOf(value));
                break;
        }
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets settings.
     *
     * @return the settings
     */
    public Settings getSettings() {
        return settings;
    }

    /**
     * Sets settings.
     *
     * @param settings the settings to set
     */
    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    /**
     * Gets todo.
     *
     * @return the todo
     */
    public TodoList getTodo() {
        return todo;
    }

    /**
     * Sets todo.
     *
     * @param todo the todo to set
     */
    public void setTodo(TodoList todo) {
        this.todo = todo;
    }
}
