# capacitor-datawedge

An plugin for Android to enable the Zebra DataWedge SDK

## Install

```bash
npm install capacitor-datawedge
npx cap sync
```

## API

<docgen-index>

* [`sendCommand(...)`](#sendcommand)
* [`setConfigProfile(...)`](#setconfigprofile)
* [`echo(...)`](#echo)
* [`enable()`](#enable)
* [`disable()`](#disable)
* [`enableScanner()`](#enablescanner)
* [`disableScanner()`](#disablescanner)
* [`startScanning()`](#startscanning)
* [`stopScanning()`](#stopscanning)
* [`addListener('scan', ...)`](#addlistenerscan-)
* [`__registerReceiver()`](#__registerreceiver)
* [Interfaces](#interfaces)
* [Type Aliases](#type-aliases)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### sendCommand(...)

```typescript
sendCommand(options: { command: string; }) => Promise<void>
```

| Param         | Type                              |
| ------------- | --------------------------------- |
| **`options`** | <code>{ command: string; }</code> |

--------------------


### setConfigProfile(...)

```typescript
setConfigProfile(options: { config: any; }) => Promise<void>
```

| Param         | Type                          |
| ------------- | ----------------------------- |
| **`options`** | <code>{ config: any; }</code> |

--------------------


### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### enable()

```typescript
enable() => Promise<void>
```

Enables DataWedge

Broadcasts intent action with `.ENABLE_DATAWEDGE` extra set to `true`

**Since:** 0.0.3

--------------------


### disable()

```typescript
disable() => Promise<void>
```

Disables DataWedge

Broadcasts intent action with `.ENABLE_DATAWEDGE` extra set to `false`

**Since:** 0.0.3

--------------------


### enableScanner()

```typescript
enableScanner() => Promise<void>
```

Enables physical scanner

Broadcasts intent action with `.SCANNER_INPUT_PLUGIN` extra set to `ENABLE_PLUGIN`

**Since:** 0.0.3

--------------------


### disableScanner()

```typescript
disableScanner() => Promise<void>
```

Disables physical scanner

Broadcasts intent action with `.SCANNER_INPUT_PLUGIN` extra set to `DISABLE_PLUGIN`

**Since:** 0.0.3

--------------------


### startScanning()

```typescript
startScanning() => Promise<void>
```

Starts software scanning trigger

Broadcasts intent action with `.SOFT_SCAN_TRIGGER` extra set to `START_SCANNING`

**Since:** 0.1.2

--------------------


### stopScanning()

```typescript
stopScanning() => Promise<void>
```

Stops software scanning trigger

Broadcasts intent action with `.SOFT_SCAN_TRIGGER` extra set to `STOP_SCANNING`

**Since:** 0.1.2

--------------------


### addListener('scan', ...)

```typescript
addListener(eventName: 'scan', listenerFunc: ScanListener) => Promise<PluginListenerHandle> & PluginListenerHandle
```

Listen for successful barcode readings

***Notice:*** Requires intent action to be set to `com.capacitor.datawedge.RESULT_ACTION` in current DataWedge profile (it may change in the future)

| Param              | Type                                                  |
| ------------------ | ----------------------------------------------------- |
| **`eventName`**    | <code>'scan'</code>                                   |
| **`listenerFunc`** | <code><a href="#scanlistener">ScanListener</a></code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt; & <a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

**Since:** 0.1.0

--------------------


### __registerReceiver()

```typescript
__registerReceiver() => Promise<void>
```

Internal method to register intent broadcast receiver 

THIS METHOD IS FOR INTERNAL USE ONLY

**Since:** 0.1.3

--------------------


### Interfaces


#### PluginListenerHandle

| Prop         | Type                                      |
| ------------ | ----------------------------------------- |
| **`remove`** | <code>() =&gt; Promise&lt;void&gt;</code> |


#### ScanListenerEvent

| Prop       | Type                        | Description     | Since |
| ---------- | --------------------------- | --------------- | ----- |
| **`data`** | <code>string</code>         | Data of barcode | 0.1.0 |
| **`type`** | <code>string \| null</code> | Type of barcode | 0.2.1 |


### Type Aliases


#### ScanListener

<code>(state: <a href="#scanlistenerevent">ScanListenerEvent</a>): void</code>

</docgen-api>
