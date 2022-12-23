import pureconfig.ConfigSource
import Config.*

class MySuite extends munit.FunSuite {

  // Note: If no config present in test/resources, main/resources will be tried
  test("Tests prefer reading from test/resources") {
    val config = ConfigSource.default.loadOrThrow[ApplicationConfig]
    println(config)
    assertEquals(
      config,
      ApplicationConfig(List(), ServerConfig("localhost", 4321))
    )
  }
}
