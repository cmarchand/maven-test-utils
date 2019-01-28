/*
 * Copyright 2019 Christophe Marchand
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package top.marchand.maven.test.utils;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Various utility methods
 * @author cmarchand
 */
public class TestUtils {
    private static File targetDirectory;
    private static File projectDirectory;
    private static String localRepositoryPath;
    private static File localRepositoryFile;

    /**
     * Returns project directory.
     * Only works if java test compiled files go to <tt>target/test-classes</tt>
     * @return The project location
     * @throws URISyntaxException In case of problem
     */
    public static File getProjectDirectory() throws URISyntaxException {
        if(projectDirectory==null) {
            projectDirectory = new File(TestUtils.class.getClassLoader().getResource("").toURI()).getParentFile().getParentFile();
        }
        return projectDirectory;
    }
    
    /**
     * Returns <tt>target/</tt> project directory
     * @return <tt>target/</tt> directory, in a standard maven project
     * @throws URISyntaxException  In case of problem
     */
    public static File getTargetDirectory() throws URISyntaxException {
        if(targetDirectory==null) {
            targetDirectory = new File(getProjectDirectory(), "target");
        }
        return targetDirectory;
    }
    
    /**
     * Returns the local repository location, as an absolute path.
     * @return Absolute local repository location.
     */
    public static String getLocalRepositoryPath() {
        if(localRepositoryPath==null) {
            localRepositoryPath = getLocalRepositoryFile().getAbsolutePath();
        }
        return localRepositoryPath;
    }

    /**
     * Returns the local maven repository location.
     * @return Local repository location
     */
    public static File getLocalRepositoryFile() {
        if(localRepositoryFile==null) {
            // TODO : compléter en fonction de la configuration des Jenkins
            File home = new File(System.getProperty("user.home"));
            File m2 = new File(home, ".m2");
            localRepositoryFile = new File(m2,"repository");
        }
        return localRepositoryFile;
    }
}
