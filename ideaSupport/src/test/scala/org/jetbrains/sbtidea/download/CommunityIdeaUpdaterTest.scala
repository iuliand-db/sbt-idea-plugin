package org.jetbrains.sbtidea.download

import java.nio.file.{Files, Paths}

import org.jetbrains.sbtidea.Keys.String2Plugin
import org.jetbrains.sbtidea.download.idea.IdeaMock
import org.jetbrains.sbtidea.{ConsoleLogger, pathToPathExt}
import org.scalatest.{FunSuite, Ignore, Matchers}
import sbt._

//@Ignore
final class CommunityIdeaUpdaterTest extends FunSuite with Matchers with IdeaMock with ConsoleLogger {

  test("IdeaUpdater Integration Test") {
    val dumbModeKey = "IdeaUpdater.dumbMode"
    sys.props += dumbModeKey -> "idea"
//    val tmpDir = Files.createTempDirectory("IdeaUpdaterTest")
    val tmpDir = Paths.get("/", "tmp", "IdeaUpdater")
    Files.createDirectories(tmpDir.resolve("plugins"))
//    val updater = new CommunityIdeaUpdater(tmpDir, logger)
//    updater.updateIdeaAndPlugins(
//      BuildInfo.apply("192.6262.9", Keys.IntelliJPlatform.IdeaCommunity, None),
//      "mobi.hsz.idea.gitignore".toPlugin :: "org.intellij.scala:2019.2.1144:Nightly".toPlugin :: Nil
//    )
//    sbt.IO.delete(tmpDir.toFile)
    sys.props -= dumbModeKey
  }

  test("install mock IDEA test") {
//    val tmpDir = Files.createTempDirectory(getClass.getSimpleName)
    val tmpDir = Paths.get("/tmp/CommunityIdeaUpdaterTest4519926325700609027")
    val ideaVersion = "193.6494.35"
    val updater = new CommunityUpdater(
      tmpDir / ideaVersion,
      IDEA_BUILDINFO.copy(buildNumber = ideaVersion),
      "mobi.hsz.idea.gitignore".toPlugin :: "org.intellij.scala:2019.2.1144:Nightly".toPlugin :: Nil
    )
    updater.update()
  }

}
