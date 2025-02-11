# OSGi Service Ranking Example

This project showcases how a service can be overriden using Service Ranking annotation in OSGi.

## Sample

This project overrides the MessageGateway service and forces a custom implementation be selected when someone uses an @Reference in the codebase.

When we use the Asset Share service in AEMaaCS which leverages the existing MessageGateway service we see that ours is instead selected because our [Service Ranking](https://docs.osgi.org/specification/osgi.core/7.0.0/framework.service.html#framework.service.servicerankingorder) is higher.

Example log showcasing the overlay.

```
11.02.2025 14:56:46.418 *INFO* [06433050-ff7f-4c2a-9e04-a7d211df7038] com.adobe.aem.dam.impl.modifiable.AsyncShareJobHandler Preparing to perform async share of 1 items
11.02.2025 14:56:46.421 *INFO* [06433050-ff7f-4c2a-9e04-a7d211df7038] com.day.cq.dam.core.impl.assetlinkshare.AdhocAssetShareServiceImpl Node for adhoc asset share already exists at /var/dam/share/ee628991_40bd_4894_86ce_c9c56cccdc35
11.02.2025 14:56:46.421 *INFO* [06433050-ff7f-4c2a-9e04-a7d211df7038] com.day.cq.dam.core.impl.assetlinkshare.AdhocAssetShareServiceImpl Existing adhoc asset share node was created by current user
11.02.2025 14:56:46.421 *INFO* [06433050-ff7f-4c2a-9e04-a7d211df7038] com.day.cq.dam.core.impl.assetlinkshare.AdhocAssetShareServiceImpl Share definition has 1 email addresses associated with it.
11.02.2025 14:56:46.425 *INFO* [06433050-ff7f-4c2a-9e04-a7d211df7038] com.day.cq.dam.core.impl.assetlinkshare.AdhocAssetShareHelper Received 'https://author-p11453-e1510804.adobeaemcloud.com/' from externalizer for domain author
11.02.2025 14:56:46.425 *INFO* [06433050-ff7f-4c2a-9e04-a7d211df7038] com.day.cq.dam.core.impl.assetlinkshare.AdhocAssetShareHelper Using externalized host https://author-p11453-e1510804.adobeaemcloud.com for share link
11.02.2025 14:56:46.425 *INFO* [06433050-ff7f-4c2a-9e04-a7d211df7038] com.day.cq.dam.core.impl.assetlinkshare.AdhocAssetShareHelper Received 'https://author-p11453-e1510804.adobeaemcloud.com/' from externalizer for domain author
11.02.2025 14:56:46.425 *INFO* [06433050-ff7f-4c2a-9e04-a7d211df7038] com.day.cq.dam.core.impl.assetlinkshare.AdhocAssetShareHelper Using externalized host https://author-p11453-e1510804.adobeaemcloud.com for share link
11.02.2025 14:56:46.425 *INFO* [06433050-ff7f-4c2a-9e04-a7d211df7038] com.day.cq.dam.core.impl.assetlinkshare.AdhocAssetShareServiceImpl Adhoc asset share definition has been configured to send email
11.02.2025 14:56:46.426 *INFO* [06433050-ff7f-4c2a-9e04-a7d211df7038] com.mysite.core.services.SupportEmailService SupportEmailService handles has been called
11.02.2025 14:56:46.429 *INFO* [06433050-ff7f-4c2a-9e04-a7d211df7038] com.mysite.core.services.SupportEmailService SupportEmailService handles has been called
11.02.2025 14:56:46.429 *INFO* [06433050-ff7f-4c2a-9e04-a7d211df7038] com.mysite.core.services.SupportEmailService Calling send method in SupportEmailService
11.02.2025 14:56:46.429 *INFO* [06433050-ff7f-4c2a-9e04-a7d211df7038] com.day.cq.dam.core.impl.assetlinkshare.AdhocAssetShareHelper Email share message sent.
```

## Modules

The main parts of the template are:

* [core:](core/README.md) Java bundle containing all core functionality like OSGi services, listeners or schedulers, as well as component-related Java code such as servlets or request filters.

## How to build

To build all the modules run in the project root directory the following command with Maven 3:

    mvn clean install

To deploy only the bundle to the author, run

    mvn clean install -PautoInstallBundle

## Documentation

The build process also generates documentation in the form of README.md files in each module directory for easy reference. Depending on the options you select at build time, the content may be customized to your project.

## Testing

There are three levels of testing contained in the project:

### Unit tests

This show-cases classic unit testing of the code contained in the bundle. To
test, execute:

    mvn clean test

## Maven settings

The project comes with the auto-public repository configured. To setup the repository in your Maven settings, refer to:

    http://helpx.adobe.com/experience-manager/kb/SetUpTheAdobeMavenRepository.html
