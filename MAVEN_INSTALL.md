# Maven Installation Guide

This guide provides instructions for installing Apache Maven on different operating systems.

## Windows

1. Download the Maven zip file from the [Apache Maven site](https://maven.apache.org/download.cgi).
2. Unzip it to a directory of your choice (e.g., `C:\Program Files\Apache\maven`).
3. Add Maven's `bin` directory to your PATH environment variable:
    - Right-click on 'This PC' or 'My Computer' and select 'Properties'.
    - Click on 'Advanced system settings'.
    - Click on 'Environment Variables'.
    - Under 'System variables', find and select 'Path', then click 'Edit'.
    - Click 'New' and add the path to Maven's bin directory (e.g., `C:\Program Files\Apache\maven\bin`).
    - Click 'OK' to close all dialogs.
4. Open a new command prompt and run `mvn -version` to verify the installation.

## macOS (using Homebrew)

1. Open Terminal.
2. Install Homebrew if you haven't already:
   ```
   /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
   ```
3. Install Maven:
   ```
   brew install maven
   ```
4. Verify the installation:
   ```
   mvn -version
   ```

## Linux (Ubuntu/Debian)

1. Open Terminal.
2. Update package index:
   ```
   sudo apt update
   ```
3. Install Maven:
   ```
   sudo apt install maven
   ```
4. Verify the installation:
   ```
   mvn -version
   ```

## Verifying Installation

After installation, run the following command to ensure Maven is correctly installed:

```
mvn -version
```

This should display the Maven version, Java version, and other system information.

## Troubleshooting

If you encounter any issues:

1. Ensure JAVA_HOME environment variable is set correctly.
2. Check if the PATH includes the Maven bin directory.
3. Restart your terminal or command prompt after making environment changes.
4. If using an IDE, restart it to recognize the new Maven installation.

For more detailed information, visit the [official Maven installation guide](https://maven.apache.org/install.html).