# Gradle SpringBoot + Angular template

This skeleton supplies you with a

* SpringBoot Java backend with WebFlux
* Angular Frontend
* OpenAPI api first 

It is authored as a gradle composite build.

## Frontend

The Frontend project is using the gradle node plugin
and wraps some NPM tasks. It also provides an initialization
task creating a fresh project.

## Backend

The backend consists of a sub-project build containing

* app
* domain
* persistence

The script `addSubproject.sh` can be used to add another
subproject to the backend, e.g. `domain.cockatail.api`. It will
create a skeleton with all the needed files and directories and also appends
the project as to the `settings.gradle`.

There are convention plugins in `buildSrc` for `common`, `library` and `application`
dependencies. `Common` is used to set common dependencies, e.g. `spring-boot-starter` for all
projects.

Dependency management is realized by using the spring boot `mavenBOM` as `enforcedPlatform` in
the backend root `build.gralde` as `allprojects` dependency.

### Creating a new subproject

To create a new subproject without to much hassle you can use the `createSubProject` task in the
backend project. You must supply `-PsubPackage=...` where `...`is e.g. `domain.newDomain`. This will
create the needed directory structure and includes the subproject in the backend build. By default, a
`build.gradle` with only the `java-library-conventions` plugin applied is created.

Please see `gradle/create.gradle` for details.

# How to get started

You could start directly with this setup. But most likely you want to set other
project names.

| File                              | What                                 | Description                                                                                                                                          |
|-----------------------------------|--------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------|
| settings.gradle                   | includeBuild('dir') { name = 'XXX' } | Include Build looks in the 'dir' directory for a project named like the directory. If your projecct has another name, set it as name in the closure. |
| settings.gradle                   | rootProject.name                     | Your root projects name.  While whitespaces are allowed, some IDEs may have problems with whitespaces in project names.                              |
| frontend/settings.gradle          | rootProject.name                     | Your root projects name.  While whitespaces are allowed, some IDEs may have problems with whitespaces in project names.                              |
| frontend/gradle.properties        | all                                  | Set the versions you want to use                                                                                                                     |
| backend/settings.gradle           | rootProject.name                     | Your root projects name.  While whitespaces are allowed, some IDEs may have problems with whitespaces in project names.                              |
| backend/gradle.properties         | all                                  | Set the versions you want to use                                                                                                                     |
| backend/build.gradle              | group                                | Set it to the value you have chosen                                                                                                                  |
| backend/app/src/...               | package names                        | Adjust to the package name you have chosen                                                                                                           |
 | backend/addSubProject.sh          | SUBPROJECT_BASE_PACKAGE | Adjust to the same as group in build.gradle |
 | api/...yaml                       | Filename | Adjust to a more descriptive file name |
 | backend/app/gradle/openapi.gradle | inputSpec | Adjust to correct file name |
| frontend/gradle/openapi.gradle | inputSpec | Adjust to correct file name |

Best do a fulltext search for 'template' to be sure you did not forget something