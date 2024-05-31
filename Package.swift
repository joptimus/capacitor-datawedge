// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorDatawedge",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapacitorDatawedge",
            targets: ["DataWedgePluginPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "DataWedgePluginPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/DataWedgePluginPlugin"),
        .testTarget(
            name: "DataWedgePluginPluginTests",
            dependencies: ["DataWedgePluginPlugin"],
            path: "ios/Tests/DataWedgePluginPluginTests")
    ]
)