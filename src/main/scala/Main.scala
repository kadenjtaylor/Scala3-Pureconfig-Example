import pureconfig.ConfigSource
import Config.ApplicationConfig

@main def hello: Unit = {
  println("Attempting to read ApplicationConfig from file...")
  val c = readConfig
  println(c)
}

def readConfig = {
  ConfigSource.default.loadOrThrow[ApplicationConfig]
}
