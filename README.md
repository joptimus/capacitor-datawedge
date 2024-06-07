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

</docgen-api>
