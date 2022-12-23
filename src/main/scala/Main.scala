import pureconfig.ConfigSource
import Config.ApplicationConfig

@main def hello: Unit = {
  println("Attempting to read ApplicationConfig from file...")
  val c = ConfigSource.default.loadOrThrow[ApplicationConfig]
  println(c)
}
