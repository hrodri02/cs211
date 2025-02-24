# cs211

Running the app on a mac

export PATH_TO_FX=/Library/Java/JavaVirtualMachines/javafx-sdk-23.0.2/lib
javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml *.java
java --module-path $PATH_TO_FX --add-modules javafx.controls CreateUsersFX
