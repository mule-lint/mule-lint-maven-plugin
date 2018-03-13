# Mule Lint Maven Plugin

The purpose of this project, is to be a wrapper for the
[mule-lint project](https://github.com/nuisto/mule-lint),
and easier to include within a maven build. See the
[mule-lint project](https://github.com/nuisto/mule-lint) for
more details.

The [mule-lint project](https://github.com/nuisto/mule-lint) as well as this one does not perform any assertions,
that is left up to the consumer of the resulting output file. The reasoning
behind this was really just two thoughts; 1) In order to "release early/release
often" this was left out to solve with other tools/scripts, 2) Put the
responsibility of asserting/checking to something else and not the
responsibility of this or the mule-lint project.

Keeping the assertions out of these two is not fulling set it stone, but
probably won't be a feature fullfilled for some time. Having assertions around
how often it occurs in either a project as a whole or how many times within a
file, does seem valuable to me (i.e. It's _okay_ for a logger not to have a
category declared, but if we have 20 loggers in the project without a logger, then that
might be an issue).

This plugin is only necessary if you want to invoke the [mule-lint
project](https://github.com/nuisto/mule-lint)
through maven (of course), if you want to invoke the mule-lint project by other
means, then this is not needed and you can use mule-lint directly, see the
[mule-lint project](https://github.com/nuisto/mule-lint) for more details.

## Getting Started
This project does not perform any logic, it purely passes information on to the
mule-lint application. The parameters are:
# `rules` - Required.
# `sources` - Optional.
# `output` - A file location where json formatted results are written.

```
<build>
  <plugins>
    <plugin>
      <groupId>org.nuisto</groupId>
      <artifactId>mule-lint-maven-plugin</artifactId>
      <version>0.4.0</version>
      <configuration>
        <rules>rules.txt</rules>
        <sources>src/main/app</sources>
        <output>mule-lint-results.json</output>
      </configuration>
    </plugin>
  </plugins>
</build>
```

With the above configuration in your pom, you can run the plugin with:
```
mvn org.nuisto:mule-lint-maven-plugin:analyze-mule
```

## Built With

* [Maven](https://maven.apache.org/) - Build system

## Contributing

Please read [CONTRIBUTING.md](https://github.com/nuisto/mule-lint-maven-plugin/CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/nuisto/mule-lint-maven-plugin/tags). 

## Authors

* **Chad Gorshing** - *Initial work* - [cgorshing](https://gens.io/profile/cgorshing)

See also the list of [contributors](https://github.com/nuisto/mule-lint-maven-plugin/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to https://gist.github.com/PurpleBooth/109311bb0361f32d87a2 as this
  was the starting point of this README and other project related files

[![Analytics](https://beacon-cgorshing.appspot.com/UA-24556575-4/nuisto/mule-lint-maven-plugin/README.md?pixel)](https://github.com/nuisto/mule-lint-maven-plugin/README.md)
