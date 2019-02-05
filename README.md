# Courseware
A collection of small applications used for demonstrations and educational purposes.

## Guidelines

Follows some guidelines for this repository to keep consistency among the projects.

### Naming conventions for packages

*Base package*: co.aurasphere.courseware\
*Specific package for demo projects*: BASE_PACKAGE + (java|j2ee).(technology)\
*Specific package for integration projects*: BASE_PACKAGE + (java|j2ee).integration

### Building

Each Java/J2EE project must use Maven with the following GAV conventions:

*GroupId*: co.aurasphere.courseware\
*ArtifactId for demo projects*: [technology]-demo\
*ArtifactId for integration projects*: [technologies]-integration\
*Version*: 1.0.0\
*Packaging*: WAR (must be present only for J2EE projects)

### Code complexity

The code must be minimal and simple, enough to give a basic introduction on the mechanics of a specific technology but at the same time not enough to become a brain teaser and generate confusions. Further in-depth analysis is out of the scope of this repository.

### Comments

Since this repository's main function is educational, the code must be heavily commented and each element must have its own JavaDoc. Moreover, each file will begin with a non-lucrative license header in order to give credit to the author.

### J2EE projects

J2EE specific features (i.e. servlets and the like) must be imported as dependencies inside the <code>pom.xml</code> instead of relying on Eclipse <code>.classpath</code> files.

### JavaScript projects

Some frontend only projects make uses of AJAX features. This may become annoying when trying to run them since you will have to disable the CORS policy in your browser or run it on a web server. In order to make this easier and at the same time to mark those projects, each of them will be bundled with a <code>.project</code> file to import it inside Eclipse and run it on any web server (not necessarily an application one). Obviously, you can just take the project content and put it on a web server of your choice instead.

## Contributing

This projects accepts contribution but they will have to strictly adhere to all the previous guidelines. I'll also reserve the right to reject any pull requests due to new rules that come to my mind at the moment or other kinds of problematics that I may haven't take into account yet. In any case, contributions are still appreciated even if they may not be merged.